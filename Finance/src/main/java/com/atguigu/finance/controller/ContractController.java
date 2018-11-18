package com.atguigu.finance.controller;

import com.atguigu.finance.bean.NplmBorrowerInfo;
import com.atguigu.finance.bean.NplmLoanContract;
import com.atguigu.finance.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;

    @RequestMapping("contractList")
    public String contractList(HttpServletRequest request){
         /*
        1、请求时，从数据库中获取合同列表的List集合及合同列表需要的数据，存到request域中，用于页面展示
         */
        /*List<NplmBorrowerInfo> nplmBorrowerInfos = contractService.selectAll();
        //查看是否获取到数据
        for (NplmBorrowerInfo nplmBorrowerInfo : nplmBorrowerInfos) {
            System.out.println(nplmBorrowerInfo.getClientName());
        }
        request.setAttribute("nplmBorrowerInfos",nplmBorrowerInfos);*/
        List<NplmLoanContract> nplmLoanContracts = contractService.selectNplmLoanContractList();

        /*for (NplmLoanContract nplmLoanContract : nplmLoanContracts) {
            System.out.println(nplmLoanContract.getNplmBorrowerInfo().getClientName());
        }*/

        request.setAttribute("nplmLoanContracts",nplmLoanContracts);
        return "contractList";
    }

    @RequestMapping("list")
    public String list(){

        //创建贷款合同
        NplmLoanContract nplmLoanContract = new NplmLoanContract();
        nplmLoanContract.setLoanContractNum("100860001");
       // contractService.insertNplmLoanContract(nplmLoanContract);

        return "list";
    }


    @RequestMapping("selectContract")
    @ResponseBody
    public String selectContract(NplmLoanContract nplmLoanContract,HttpServletRequest httpServletRequest){

        List<NplmLoanContract> contractList = contractService.getContractList(nplmLoanContract);

       /* System.out.println(nplmLoanContract.getId());
        System.out.println(nplmLoanContract.getNplmBorrowerInfo().getClientName());
        for (NplmLoanContract loanContract : contractList) {
            System.out.println(loanContract.getBorrowerId());
        }*/

        return "success";
    }

    @RequestMapping(value = "detailList/{id}")
    public String detaliList(@PathVariable("id") String loanContractNum,HttpServletRequest request){

        System.out.println(loanContractNum);

        NplmLoanContract nplmLoanContract = contractService.selectNplmLoanContractOne(loanContractNum);


        System.out.println(nplmLoanContract.getLoanContractNum());

        System.out.println(nplmLoanContract.getNplmRepaymentPlan().getLoanContractNum());

        request.setAttribute("nplmLoanContract",nplmLoanContract);


        return "detailList";
    }


}

