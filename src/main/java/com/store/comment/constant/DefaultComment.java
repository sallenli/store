package com.store.comment.constant;

/**
 * 评论类型常量值
 */
public class DefaultComment {

    /**
     * 是否是默认评论
     */
  public static final Integer YES = 1;
  public static final Integer NO = 0;

    /**
     * 评论状态
     */
    //审核中
  public static final Integer APPROVING = 1;
    //审核通过
  public static final Integer APPROVED = 2;
    //审核不通过
  public static final Integer APPROVE_REJECT = 3;
  //已移除
  public static final Integer REMOVED = 4;

  /**
   * 评论类型 好 、 中 、差
   */

  public static final Integer GOOD_COMMENT = 1;

  public static final Integer MEDIUM_COMMENT = 2;

  public static final Integer BAD_COMMENT = 3;
  //异常状态评论
  public static final Integer ERROR_COMMENT = 4;

  /**
   *评论是否晒图
   */
  public static final Integer SHOW_PICTURE = 1;
  public static final Integer NOT_SHOW_PICTURE = 0;

  /**
   * 评论图片目录路径（绝对、相对）
   */

  public static final String RELATIVE = "relative";
  public static final String ABSOLUTE = "absolute";

  /**
   * 评论分数
   */
  public static final Integer  COMMENT_SCORE_ONE = 1;
  public static final Integer  COMMENT_SCORE_TWO = 2;
  public static final Integer  COMMENT_SCORE_THREE = 3;
  public static final Integer  COMMENT_SCORE_FOUR = 4;
  public static final Integer  COMMENT_SCORE_FIVE = 5;

  /**
   * 自动评论用的默认评论
   */
  public static final String COMMENT_CONTENT_DEFAULT = "默认评论内容";
}
