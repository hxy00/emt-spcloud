package com.emt.euraka.discovery.service.impl;


import com.emt.euraka.discovery.dao.entity.PayAccountCard;
import com.emt.euraka.discovery.dao.inter.IPayAccountCardDao;
import com.emt.euraka.discovery.dao.inter.IPayAccountDao;
import com.emt.euraka.discovery.pojo.PayAccountVO;
import com.emt.euraka.discovery.service.inter.IPayAccountSv;
import com.emt.euraka.discovery.util.ReturnObject;
import com.github.pagehelper.PageInfo;
import com.xiaoleilu.hutool.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Huang on 2017-03-16.
 */
@Service("payAccountSvImpl")
public class PayAccountSvImpl implements IPayAccountSv
{
    private static Logger logger = LoggerFactory
            .getLogger(PayAccountSvImpl.class);

    @Autowired
    private IPayAccountDao payAccountDao;

    @Autowired
    private IPayAccountCardDao payAccountCardDao;

    @Override
    public List<Map<String, Object>> getAccountByPayeeId(String company_code, String payee_id)
    {
        return payAccountDao.getAccountByPayeeId(company_code, payee_id);
    }

    @Override
    public PageInfo pageAccount(int pageIndex, int pageSize, PayAccountVO bPayAccountVO)
    {
        return payAccountDao.pageAccount(pageIndex, pageSize, bPayAccountVO);
    }

    /**
     * 设置别名或设置默认标识
     *
     * @param company_code
     * @param payee_id
     * @param account_id
     * @param alias
     * @param default_id
     * @return
     */
    @Override
    public ReturnObject SetAliasOrDefault(String company_code, String payee_id, String account_id, String alias, int default_id)
    {
        List<String> msg = new ArrayList<String>();
        if (StrUtil.isEmpty(company_code))
            msg.add("套帐号不能为空!");
        if (StrUtil.isEmpty(payee_id))
            msg.add("网点编号不能为空!");
        if (StrUtil.isEmpty(account_id))
            msg.add("银行卡号不能为空!");

        PayAccountCard payAccountCard = new PayAccountCard();
        payAccountCard.setAccount_id(account_id);
        payAccountCard.setCompany_code(company_code);
        payAccountCard.setPayee_id(payee_id);
//        List<Map<String, Object>> list = this.selectBankCardById(payAccountCard);
//        if (list == null || list.size() == 0)
//            msg.add("没有该网点银行卡号!");

        if (msg.size() > 0)
        {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, msg, null, msg.size());
        }
        if (payAccountCardDao.SetAliasOrDefault(company_code, payee_id, account_id, alias, default_id) > 0)
        {
            msg.clear();
            ;
            msg.add("提交成功!");
        }
        return new ReturnObject(ReturnObject.SuccessEnum.success, msg, null, msg.size());
    }


    /**
     * 根据网点编号获取网点总帐信息
     *
     * @param company_code
     * @param payee_id
     * @return
     */
    @Override
    public ReturnObject LedgersByPayeeId(String company_code, String payee_id) {
        List<String> msg = new ArrayList<String>();
        if (StrUtil.isEmpty(company_code))
            msg.add("套帐号不能为空!");
        if (StrUtil.isEmpty(payee_id))
            msg.add("网点编号不能为空!");
        if (msg.size() > 0) {
            return new ReturnObject(ReturnObject.SuccessEnum.fail, msg, null, msg.size());
        } else {
            msg.clear();
            msg.add("获取总帐信息");
            List<Map<String, Object>> list = payAccountDao.LedgersByPayeeId(company_code, payee_id);
            return new ReturnObject(ReturnObject.SuccessEnum.success, msg, list, msg.size());
        }
    }



}

