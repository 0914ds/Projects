package cloud.seckilled.service.domain;

import java.util.List;

import cloud.seckilled.service.dto.Exposer;
import cloud.seckilled.service.model.Seckill;

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
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(Long seckillId);

}