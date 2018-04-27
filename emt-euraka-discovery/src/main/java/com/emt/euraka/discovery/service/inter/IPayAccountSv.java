package com.emt.euraka.discovery.service.inter;

import com.emt.euraka.discovery.pojo.PayAccountVO;
import com.emt.euraka.discovery.util.ReturnObject;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Huang on 2017-03-16.
 */
public interface IPayAccountSv {
    /**
     * @category 获取帐户信息
     * @param company_code
     * @param payee_id
     * @return
     */
    List<Map<String, Object>> getAccountByPayeeId(String company_code, String payee_id);


    /**
     * 帐户分页查询
     * @param pageIndex
     * @param pageSize
     * @param bPayAccountVO
     * @return
     */
    PageInfo pageAccount(int pageIndex, int pageSize, PayAccountVO bPayAccountVO);


    /**
     * 设置别名或设置默认标识
     * @param company_code
     * @param payee_id
     * @param account_id
     * @param alias
     * @param default_id
     * @return
     */
    ReturnObject SetAliasOrDefault(String company_code, String payee_id, String account_id, String alias, int default_id);

    /**
     * 根据网点编号获取网点总帐信息
     * @param company_code
     * @param payee_id
     * @return
     */
    ReturnObject LedgersByPayeeId(String company_code, String payee_id);


}
