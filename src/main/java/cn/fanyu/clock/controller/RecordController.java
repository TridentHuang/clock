package cn.fanyu.clock.controller;


import cn.fanyu.clock.dto.in.PunchInDto;
import cn.fanyu.clock.dto.in.RecordInDto;
import cn.fanyu.clock.model.Result;
import cn.fanyu.clock.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author DongJin
 * @since 2019-11-27
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private IRecordService recordService;

    //打卡
    @PostMapping("/punch")
    Result punch(@RequestBody PunchInDto punchInDto) {
        return recordService.punch(punchInDto);
    }

    //获取打卡记录
    @PostMapping("/getData")
    Result getData(@RequestBody RecordInDto recordInDto) {
        return recordService.getData(recordInDto);
    }
}
