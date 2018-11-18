package com.atguigu.finance.service;

import com.atguigu.finance.bean.NplmBorrowerInfo;
import com.atguigu.finance.bean.NplmLoanContract;
import com.atguigu.finance.mapper.NplmBorrowerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ContractService {

    List<NplmBorrowerInfo> selectAll ();

    //插入贷款合同表数据
    void insertNplmLoanContract(NplmLoanContract nplmLoanContract);

    int insertNplmBorrowerInfo(NplmBorrowerInfo nplmBorrowerInfo);

    //查询所有贷款合同
    List<NplmLoanContract> selectNplmLoanContractList();

    //通过条件查询贷款合同
    List<NplmLoanContract> getContractList(NplmLoanContract nplmLoanContract);

    //通过条件查询贷款合同(何江泽）
    List<NplmLoanContract> getOneContract(NplmLoanContract nplmLoanContract);


    NplmLoanContract  selectNplmLoanContractOne(String loanContractNu);

}
