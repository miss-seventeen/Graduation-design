package com.ambow.service;

import com.ambow.bean.FamllyInfo;
import com.ambow.dao.FamllyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FamllyService {
    @Autowired
    private FamllyDao famllyDao;
    public void addFamlly(FamllyInfo famllyInfo){
        famllyDao.addFamlly(famllyInfo);
    }
    public void delFamlly(int id){
        famllyDao.delFamlly(id);
    }
    public void updateFamlly(FamllyInfo famllyInfo){
        famllyDao.updateFamlly(famllyInfo);
    }
    public List<FamllyInfo> selectAll(){
        return famllyDao.allFamlly();
    }
    public FamllyInfo byIdFamlly(FamllyInfo famllyInfo){
        int id=famllyInfo.getFid();
        return famllyDao.byIdFamlly(id);
    }
    public FamllyInfo selectByNameAndPwd(int a,String b){
        return famllyDao.selectByNameAndPwd(a,b);
    }

    public void forget(FamllyInfo famllyInfo) {
        System.out.println("忘记密");
        FamllyInfo famlly=famllyDao.selectIsName(famllyInfo.getFname());
        if(famlly!=null){
            famllyDao.upPwd(famlly.getFid(),"123456");
            System.out.println("判断");
        }
    }

}
