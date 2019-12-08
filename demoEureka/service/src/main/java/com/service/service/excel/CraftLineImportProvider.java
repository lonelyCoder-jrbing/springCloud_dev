package com.service.service.excel;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CraftLineImportProvider extends AbstractOrderImportProvider<MemberTagModel, MemberTagEntity> {
    @Override
    protected Class importTarget() {
        return MemberTagModel.class;
    }

    @Override
    protected List<MemberTagEntity> fillData() {
        List<MemberTagEntity> responsesList = new ArrayList<MemberTagEntity>();
        for (MemberTagModel e : datas) {
            MemberTagEntity response = new MemberTagEntity();
            MemberTagEntity entity = new MemberTagEntity();
            entity.setMemberId(response.getMemberId());
            entity.setTagType(response.getTagType());
            entity.setTagValue(response.getTagValue());
            responsesList.add(entity);
        }
        return responsesList;
    }

    @Override
    public OrderImportProvider<MemberTagModel, MemberTagEntity> check() {
        int line = 2;
//        StringBuffer sb1 = new StringBuffer();
        List<String> productListTable = new ArrayList<>();
//        List<String> productListTable = context.getPropRepository().selectList(new EntityWrapper<PropDO>().eq("location_code", datas.get(0).getLocationCode())).stream().map(PropDO::getProductCode).collect(Collectors.toList());
        //判断地点编码是否全部一样
        List<String> locationList = datas.stream().map(MemberTagModel::getMemberId).collect(Collectors.toList());
        List<String> onlyOne = locationList.stream().distinct().collect(Collectors.toList());
        //同一批的商品编码必须唯一
        List<String> productCodeList = datas.stream().map(MemberTagModel::getTagType).collect(Collectors.toList());

        for (MemberTagModel e : datas) {
            StringBuffer sb = new StringBuffer();
            //是否存在于数据库中
            if (!productListTable.contains(e.getMemberId())) {
                sb.append("# 商品编码" + e.getMemberId() + "不存在");
            }
          /*  List<String> verify = productCodeList.stream().filter(v -> v.equals(e.getProductCode())).collect(Collectors.toList());
            if (verify.size() > 1) {
                sb.append("# 同一批的商品编码必须唯一！");
            }
            if (!e.getLocationCode().equals(onlyOne.get(0))) {
                sb.append("# 同一批地点编码必须一致！");
            }
            String locationCode = e.getLocationCode();
            if (StringUtils.isEmpty(locationCode)) {
                sb.append("#地点编码不能为空");
            }
            String workshopCode = e.getWorkshopCode();
            if (StringUtils.isEmpty(workshopCode)) {
                sb.append("#车间编码不能为空");
            }
            String lineCode = e.getLineCode();
            if (StringUtils.isEmpty(lineCode)) {
                sb.append("#产线编码不能为空");
            }
            String productCode = e.getProductCode();
            if (StringUtils.isEmpty(productCode)) {
                sb.append("#商品编码不能为空");
            }
            String reckonFactor = e.getReckonFactor();
            if (StringUtils.isEmpty(reckonFactor)) {
                sb.append("#计算因子不能为空");
            }
            String feeTypeOne = e.getFeeTypeOne();
            if (StringUtils.isEmpty(feeTypeOne)) {
                sb.append("#人工 费用类型不能为空");
            }
            String unitOne = e.getUnitOne();
            if (StringUtils.isEmpty(unitOne)) {
                sb.append("#人工 单位不能为空");
            }
            BigDecimal numberOne = e.getNumberOne();
            if (null == numberOne) {
                sb.append("#人工 数量不能为空");
            }

           /* String feeTypeTwo = e.getFeeTypeTwo();
            if (StringUtils.isEmpty(feeTypeTwo)) {
                sb.append("#机器 费用类型不能为空");
            }
            String unitTwo = e.getUnitTwo();
            if (StringUtils.isEmpty(unitTwo)) {
                sb.append("#机器 单位不能为空");
            }
            BigDecimal numberTwo = e.getNumberTwo();
            if (null==numberTwo) {
                sb.append("#机器 数量不能为空");
            }

            String feeTypeThree = e.getFeeTypeThree();
            if (StringUtils.isEmpty(feeTypeThree)) {
                sb.append("#辅料 费用类型不能为空");
            }
            String unitThree = e.getUnitThree();
            if (StringUtils.isEmpty(unitThree)) {
                sb.append("#辅料 单位不能为空");
            }
            BigDecimal numberThree = e.getNumberThree();
            if (null==numberThree) {
                sb.append("#辅料 数量不能为空");
            }*/
            boolean isOK = sb.length() == 0;

            /* 成功日志 */
            if (isOK) {
                appendLog4Success(line);
            }
            /* 失败日志 */
            if (isOK == false) {
                appendLog4Failed(line, sb.toString());
            }
            line++;
        }
        return this;
    }
}
