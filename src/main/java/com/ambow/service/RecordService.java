package com.ambow.service;

import com.ambow.bean.RecordInfo;
import com.ambow.bean.UserInfo;
import com.ambow.dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;
    public void addRecord(RecordInfo recordInfo){
        recordDao.addRecord(recordInfo);
    }
    public void delRecord(int id){
        recordDao.delRecord(id);
    }
    public void updateRecord(RecordInfo recordInfo){
        recordDao.updateRecord(recordInfo);
    }
    public List<RecordInfo> selectAll(){
        return recordDao.allRecord();
    }
    public RecordInfo byIdRecord(RecordInfo recordInfo){
        int id=recordInfo.getRid();
        return recordDao.byIdRecord(id);
    }

    public List<RecordInfo> allRecordServicePage(int number,int page, int yetiao) {
        System.out.println(number+"one"+page+"two"+yetiao+"three");
        return recordDao.getAllRecordPage(number,page,yetiao);
    }
    public List<RecordInfo> getAllRecord(int page, int yetiao) {
        return recordDao.getAllRecord(page,yetiao);
    }

    public List<RecordInfo> byTime(int c,String a,String b,int d) {
        return recordDao.byTime(c,a,b,d);
    }

    public List<RecordInfo> byUnumRecord(UserInfo userInfo) {
        return  recordDao.byUnumRecord(userInfo);
    }

}
