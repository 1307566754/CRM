package com.sc.mapper;

import com.sc.entity.OffPerplan;
import com.sc.entity.OffPerplanExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OffPerplanMapper {
    int countByExample(OffPerplanExample example);

    int deleteByExample(OffPerplanExample example);

    int deleteByPrimaryKey(BigDecimal planid);

    int insert(OffPerplan record);

    int insertSelective(OffPerplan record);

    List<OffPerplan> selectByExample(OffPerplanExample example);

    OffPerplan selectByPrimaryKey(BigDecimal planid);

    int updateByExampleSelective(@Param("record") OffPerplan record, @Param("example") OffPerplanExample example);

    int updateByExample(@Param("record") OffPerplan record, @Param("example") OffPerplanExample example);

    int updateByPrimaryKeySelective(OffPerplan record);

    int updateByPrimaryKey(OffPerplan record);
}