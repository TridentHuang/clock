package cn.fanyu.clock.entity;

import java.time.LocalDate;
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
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 已打卡id
     */
    private String punchedUserId;

    /**
     * 打卡日期
     */
    private LocalDate punchedDay;


}
