package com.wjs.api.web;

import cn.com.common.base.rpc.RpcResponse;
import com.wjs.mb.api.dto.MemberDTO;
import com.wjs.mb.api.facade.MbFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(tags = {"会员模块"}, description = "会员模块相关接口")
@RestController
@RequestMapping(value = "/mbs", produces = APPLICATION_JSON_UTF8_VALUE)
public class MbController {
    @Autowired
    private MbFacade mbFacade;

    @ApiOperation(value = "查询会员", notes = "查询会员")
    @RequestMapping(value = "/{moduleId}", method = POST)
    public RpcResponse<MemberDTO> queryMember(@PathVariable Long moduleId, @RequestBody MemberDTO member) {
        return mbFacade.queryMember(moduleId, member);
    }
}
