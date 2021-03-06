﻿<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" language="java" %>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" --%>
<%--"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
<%--"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd"--%>
 >

<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
  <TITLE>青鸟租房 -发布房屋信息</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
  <LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514">

<script type="text/javascript" language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
<script language="JavaScript">
  $(function () {
    $.post("selectTypeAll",null,function (data) {
      for (var i=0;i<data.length;i++){
        //创建节点
        var options =$("<option  value="+data[i].id+">"+data[i].name+"</option>")

        $("#typeList").append(options)
      }

      $("#typeList").val(${house.typeId})
    },"json");


    $.post("selectDistriceAll",null,function (data) {
      for (var i=0;i<data.length;i++){
        //创建节点
        var options =$("<option  value="+data[i].id+">"+data[i].name+"</option>")

        $("#district_id").append(options)
      }

      //设置选中项
        $("#district_id").val(${house.districtId})



        var did= $("#district_id").val();

        $("#street_id>option:gt(0)").remove();
        $.post("selectByStreet",{"did":did},function (data) {

            for (var i=0;i<data.length;i++){
                //创建节点
                var options =$("<option  value="+data[i].id+">"+data[i].name+"</option>")

                $("#street_id").append(options)
            }
            $("#street_id").val(${house.streetId})

        },"json");




    },"json");









        $("#district_id").change(function () {
            var did= $(this).val();

            $("#street_id>option:gt(0)").remove();
            $.post("selectByStreet",{"did":did},function (data) {

                for (var i=0;i<data.length;i++){
                    //创建节点
                    var options =$("<option  value="+data[i].id+">"+data[i].name+"</option>")

                    $("#street_id").append(options)
                }

            },"json");

        });
  })

</script>
</HEAD>






<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新房屋信息发布</DT>
  <DD class=past>填写房屋信息</DD></DL>
<DIV class=box>
<FORM id=add_action method=post name=add.action enctype="multipart/form-data"
action=addHouseInfo>
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name=title value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD><SELECT class=text name=typeId  id="typeList"><OPTION
        value=1000>请选择</OPTION></SELECT></TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text
name=floorage value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name=price value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>

    <TD><INPUT class=text type=date name=pubdate value="<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></fmt:formatDate>"></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>
      区：${house.districtId}
      <SELECT class=text name=district_id  id="district_id">
             <option  value="">请选择</option>
      </SELECT>
      街：${house.streetId}
          <SELECT class=text name=streetId id="street_id">
                <option value="" >请选择</option>
          </SELECT>
    </TD>
  </TR>
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name=contact value="${house.contact}"> </TD></TR>
  <TR>
      <TD class=field>详细信息：</TD>
      <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD></TR>

  <TR>
      <TD class=field>上传图片：</TD>
      <TD>
          <input type="file" name="pfile" id="pfile">
      </TD></TR>

  </TBODY>


</TABLE>


<DIV class=buttons><INPUT value=立即更新 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
