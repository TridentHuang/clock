package cn.fanyu.clock.service.impl;

import cn.fanyu.clock.entity.Record;
import cn.fanyu.clock.mapper.RecordMapper;
import cn.fanyu.clock.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

}
