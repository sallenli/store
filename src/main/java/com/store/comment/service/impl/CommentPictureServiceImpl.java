package com.store.comment.service.impl;

import com.store.comment.Dao.CommentPictureDao;
import com.store.comment.constant.DefaultComment;
import com.store.comment.domain.CommentPictureDo;
import com.store.comment.domain.CommentPictureDto;
import com.store.comment.service.CommentPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Service
public class CommentPictureServiceImpl implements CommentPictureService {

    private static final Logger logger = LoggerFactory.getLogger(CommentPictureServiceImpl.class);
    /**
     * 上传图片目录
     */
    @Value("${comment.picture.upload.dir}")
    private String uploadDirPath;
    /**
     * 上传目录路径类型 relative 相对路径  absolute 绝对路径
     */
    @Value("${comment.picture.upload.type}")
    private String uploadDirType;

    @Autowired
    private CommentPictureDao commentPictureDao;
    /**
     * 添加评论图片
     * @param commentInfoId 评论信息id
     * @param files 上传的图片
     * @return 上传图片处理结果
     */
    @Override
    public Boolean saveCommentPicture(String appBasePath,Long commentInfoId, MultipartFile [] files) {
        //处理上传目录
        //上传目录为相对路径
        if(DefaultComment.RELATIVE.equals(uploadDirType)){
            //相对路径变成绝对路径
            uploadDirPath = appBasePath + uploadDirPath;
        }
        //上传图片到指定路径
        try {
            File uploadDir = new File(uploadDirPath);
            //判断文件路径是否存在
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            for (MultipartFile file: files) {
                if(file != null){
                    //上传目标图片文件路径
                    String targetFilePath = uploadDirPath +file.getOriginalFilename();
                    File targetFile = new File(targetFilePath);
                    //判断是否有重名
                    if(targetFile.exists()){
                        //移除目标文件
                        targetFile.delete();
                    }
                    //文件上传到指定目录
                    file.transferTo(targetFile);
                    //将图片上传到数据库
                    CommentPictureDo commentPictureDo = new CommentPictureDo();
                    commentPictureDo.setCommentInfoId(commentInfoId);
                    commentPictureDo.setCommentPicturePath(targetFilePath);
                    commentPictureDo.setGmtCreate(new Date());
                    commentPictureDo.setGmtModified(new Date());

                    commentPictureDao.saveCommentPicture(commentPictureDo);
                }

            }

        } catch (Exception e) {
            logger.error("CommentPictureServiceImpl.saveCommentPicture",e.getMessage());
        }

        return null;
    }
}
