package com.atguigu.finance.service.impl;


import com.atguigu.finance.bean.NplmBorrowerInfo;
import com.atguigu.finance.bean.NplmLoanContract;
import com.atguigu.finance.mapper.NplmBorrowerInfoMapper;
import com.atguigu.finance.mapper.NplmLoanContractMapper;
import com.atguigu.finance.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private NplmBorrowerInfoMapper nplmBorrowerInfoMapper;

    @Autowired
    private NplmLoanContractMapper nplmLoanContractMapper;




    @Override
    public List<NplmBorrowerInfo> selectAll() {

            List<NplmBorrowerInfo> nplmBorrowerInfos = nplmBorrowerInfoMapper.selectAll();
        return nplmBorrowerInfos;
    }

    @Override
    public void insertNplmLoanContract(NplmLoanContract nplmLoanContract) {
        int insert = nplmLoanContractMapper.insert(nplmLoanContract);

    }

    @Override
    public int insertNplmBorrowerInfo(NplmBorrowerInfo nplmBorrowerInfo) {

        int insert = nplmBorrowerInfoMapper.insert(nplmBorrowerInfo);

        return insert;

    }

    @Override
    public List<NplmLoanContract> selectNplmLoanContractList() {

        List<NplmLoanContract> nplmLoanContracts = nplmLoanContractMapper.selectNplmLoanContractList();
        return nplmLoanContracts;
    }

    @Override
    public List<NplmLoanContract> getContractList(NplmLoanContract nplmLoanContract) {

        List<NplmLoanContract> select = nplmLoanContractMapper.getSelectNplmLoanContractList(nplmLoanContract);

        return select;
    }


    @Override
    public List<NplmLoanContract> getOneContract(NplmLoanContract nplmLoanContract) {

        List<NplmLoanContract> newLoanContract = nplmLoanContractMapper.select(nplmLoanContract);

        List<NplmBorrowerInfo> nplmBorrowerInfos = new ArrayList<NplmBorrowerInfo>();
        for (NplmLoanContract loanContract : newLoanContract) {
            NplmBorrowerInfo nplmBorrowerInfo = new NplmBorrowerInfo();
            String clientName = loanContract.getNplmBorrowerInfo().getClientName();
            nplmBorrowerInfo.setClientName(clientName);
            nplmBorrowerInfos.add(nplmBorrowerInfo);
        }



        /*String clientName = newLoanContract.getNplmBorrowerInfo().getClientName();
        if (clientName!=null && clientName.length()!=0){
            NplmBorrowerInfo nplmBorrowerInfo = new NplmBorrowerInfo();
            nplmBorrowerInfo.setClientName(clientName);
            NplmBorrowerInfo newBorrowerInfo = nplmBorrowerInfoMapper.selectOne(nplmBorrowerInfo);

            newLoanContract.setNplmBorrowerInfo(newBorrowerInfo);
        }


        String city = newLoanContract.getNplmContractAttribute().getCity();
        String deptName = newLoanContract.getNplmContractAttribute().getDeptName();

        if ((city!=null&&city.length()!=0)||(deptName!=null&&deptName.length()!=0)){

            NplmContractAttribute nplmContractAttribute = new NplmContractAttribute();
            nplmContractAttribute.setCity(city);
            nplmContractAttribute.setDeptName(deptName);
            NplmContractAttribute newContractAttribute = nplmContractAttributeMapper.selectOne(nplmContractAttribute);
            newLoanContract.setNplmContractAttribute(newContractAttribute);
        }

        return newLoanContract;*/
        return null;
    }

    @Override
    public NplmLoanContract selectNplmLoanContractOne(String loanContractNu) {

        NplmLoanContract nplmLoanContract = nplmLoanContractMapper.selectNplmLoanContractOne(loanContractNu);

        return nplmLoanContract;
    }


}
