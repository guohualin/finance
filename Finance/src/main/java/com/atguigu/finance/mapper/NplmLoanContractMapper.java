package com.atguigu.finance.mapper;

import com.atguigu.finance.bean.NplmLoanContract;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NplmLoanContractMapper extends Mapper<NplmLoanContract> {

    //查询所有贷款合同
    List<NplmLoanContract> selectNplmLoanContractList ();

    //有条件的查询
    List<NplmLoanContract> getSelectNplmLoanContractList(NplmLoanContract nplmLoanContract);


    //通过合同编号查询一条合同贷款表数据
    NplmLoanContract selectNplmLoanContractOne(String loanContractNum);

}
