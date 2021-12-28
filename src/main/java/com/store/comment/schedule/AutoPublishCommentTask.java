package com.store.comment.schedule;

import com.store.comment.domain.CommentInfoDto;
import com.store.comment.service.CommentAggregateService;
import com.store.comment.service.CommentInfoService;
import com.store.order.domain.OrderInfoDto;
import com.store.order.domain.OrderItemDto;
import com.store.order.service.OrderFacadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * comment 定时器
 */
@Component
public class AutoPublishCommentTask {
    private static final Logger logger = LoggerFactory.getLogger(AutoPublishCommentTask.class);
    //订单中心service
    @Autowired
    private OrderFacadeService orderFacadeService;

    /**
     * 评论管理信息模块
     */
    @Autowired
    private CommentInfoService commentInfoService;
    /**
     * 更新评论统计信息
     */
    @Autowired
    private CommentAggregateService commentAggregateService;
    /**
     * 每隔10检查一次
      */
    @Scheduled(fixedRate =  10* 60 * 1000)
    public  void  execute(){
        try {
            //从订单中心查询 确认时间超过7天，还没有发表评论的订单
            List<OrderInfoDto> orderInfoDtos = orderFacadeService.listNotPublishedCommentOrders();
            List<Long> orderInfoIds = new ArrayList<>(orderInfoDtos.size());
            if(orderInfoDtos != null && orderInfoDtos.size() >0){
                for (OrderInfoDto orderInfoDto : orderInfoDtos) {
                    //如果订单下面没有订单条目，说明该订单有问题，跳过
                    if(orderInfoDto.getOrderItems() == null || orderInfoDto.getOrderItems().size() ==0){
                        continue;
                    }
                    orderInfoIds.add(orderInfoDto.getId());
                    //遍历订单条目
                    for (OrderItemDto orderItemDto: orderInfoDto.getOrderItems()) {
                                    //保存自动发表的评论信息
                        CommentInfoDto commentInfoDto = commentInfoService.saveAutoPublishCommentInfo(orderInfoDto, orderItemDto);
                                //更新评论统计信息
                        if(commentInfoDto != null ) {
                            commentAggregateService.updateCommentAggregate(commentInfoDto);
                        }
                        else {
                            logger.error("AutoPublishCommentTask.execute.自动评论功能失效");
                        }


                    }
                }
            }

            //通知订单中心，批量发表评论

            orderFacadeService.informBatchPublishCommentEvent(orderInfoIds);
        } catch (Exception e) {
            logger.error("AutoPublishCommentTask.execute",e.getMessage());
        }

    }

}
