package cloud.seckilled.service.service;
import java.util.List;

import seckill.common.dto.SeckillExecution;
import seckill.common.exception.RepeatKillException;
import seckill.common.exception.SeckillCloseException;
import seckill.common.exception.SeckillException;
import seckill.common.model.Seckill;

/**
 * Created by wchb7 on 16-5-13.
 * 业务接口:站在"使用者"的角度设计接口
 * 1.方法的定义的粒度.2.参数.3.返回类型(return /异常)
 */
public interface SeckillService {


    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();


    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(Long seckillId);


    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5) throws SeckillException
            , RepeatKillException, SeckillCloseException;
    
}
