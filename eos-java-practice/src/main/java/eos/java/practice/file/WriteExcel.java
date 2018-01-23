package eos.java.practice.file;

import java.io.*;

/**
 * Title: WriteExcel
 * Author: yanyuyu
 * Date: 2018-01-23 19:03
 */
public class WriteExcel {
    public static void main(String[] args) throws Exception {
        String[] strings = {"空","充电器",
                "数据线",
                "附件电池",
                "电池盖",
                "遥控器",
                "AC线",
                "单机",
                "套机",
                "主板",
                "SIM卡托",
                "电源",
                "3D眼镜",
                "电源线",
                "底座",
                "底座脖子",
                "壁挂",
                "HDMI线",
                "转接头",
                "前壳触摸屏显示组件",
                "触摸屏",
                "显示屏",
                "触摸屏显示屏组装件",
                "AV线",
                "硬盘",
                "螺丝刀",
                "SPDIF线",
                "SD卡托",
                "Sound bar",
                "音响电源线",
                "音响挂壁",
                "凳类",
                "柜类",
                "台类",
                "桌类",
                "椅类",
                "拉手类",
                "铭牌类",
                "授权类",
                "托架类",
                "宣传牌类",
                "单口类",
                "4口类",
                "8口类",
                "成品类",
                "其他",
                "传感线类",
                "解锁器类",
                "充电线",
                "滤芯",
                "logo类",
                "壳类",
                "音学器件类",
                "摄像头类",
                "FPC类",
                "振动器类",
                "Label类",
                "副板类",
                "自拍杆",
                "电源适配器",
                "腕带",
                "网关",
                "人体传感器",
                "门窗传感器",
                "无线开关",
                "工具",
                "生产辅料",
                "绳",
                "电池",
                "卡",
                "水龙头",
                "延长气嘴",
                "转接线",
                "手柄",
                "电源板",
                "标准件",
                "内锅",
                "勺子组件",
                "量杯",
                "过滤器盖",
                "内盖",
                "破泡器",
                "阀类",
                "通讯模块",
                "配件盒",
                "电机类",
                "线材类",
                "紧固件",
                "保护架",
                "相机",
                "正桨",
                "反桨",
                "帽子",
                "转轴",
                "天线",
                "散热片",
                "支架",
                "键盘类",
                "风扇类",
                "显示屏组装件",
                "固态硬盘",
                "副板",
                "传感器类",
                "蒸笼",
                "保护壳",
                "上翻显示模组",
                "前壳",
                "中框",
                "后壳",
                "音量键",
                "电源键",
                "侧键",
                "指纹识别模组",
                "接收器",
                "音频线",
                "控制器",
                "电路板类",
                "金属件类",
                "内胎",
                "外胎",
                "转接板",
                "LTE板",
                "插座",
                "OTG线",
                "相机袋",
                "颜色传感器",
                "表扣",
                "装饰件",
                "表带",
                "NFC类",
                "入网标",
                "光机类",
                "结构料",
                "包材",
                "机头盒",
                "连接器",
                "耗材",
                "附件",
                "显示屏类",
                "电子料",
                "选装附件",
                "防盗器",
                "家具类",
                "货架",
                "转接件",
                "电源底座",
                "收纳包",
                "清洁毛刷",
                "内刀头",
                "外刀网组件",
                "保护盖",
                "触控板",
                "左风扇",
                "右风扇",
                "硅胶圈",
                "贴膜" };
        File file = new File("/home/a/桌面/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while((line = reader.readLine()) != null) {
            System.out.println(strings[Integer.parseInt(line)]);
        }
    }
}