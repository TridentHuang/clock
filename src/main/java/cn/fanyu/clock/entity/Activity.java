package cn.fanyu.clock.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人id
     */
    private Integer belongUserId;

    /**
     * 会员Ids集合
     */
    private String memberUserId;

    /**
     * 打卡截止时间
     */
    private String endTime;

    /**
     * 状态（1删除）
     */
    private Integer status;


}
