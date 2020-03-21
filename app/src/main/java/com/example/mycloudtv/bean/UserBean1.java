package com.example.mycloudtv.bean;

import java.io.Serializable;
import java.util.List;

public class UserBean1 implements Serializable {

    /**
     * status : 0
     * code : OK
     * message : null
     * data : {"id":916,"userId":"74046645-fdb3-417a-92d2-4398903a20bb","userName":"test5162","passwd":"","name":"test","sex":0,"tel":"","company_screen":"","mobileNo":"13713917858","mail":"","address":"","userState":1,"pwdErrorCount":0,"remark":null,"version":0,"createTime":1583804090000,"lastLoginTime":1583804090000,"lastTime":1583804131000,"type":null,"isCompany":1,"isEmployee":1,"imgUrl":null,"roleList":[],"role":null,"company":"东莞市优世强精密科技有限公司","companyDuty":"","bossName":"","bossAddress":"","bossMoble":null,"fax":"","bankName":null,"openBank":"","bankNo":"","card_id":"","create_by":"huanghua","modify_by":"huanghua","random_no":4,"weixin_openid":null,"province":"广东省","city":"深圳市","area":"南山区","min_openid":null,"agent_user_id":"","isbox":2,"head_title":"","isdevice":1,"distribution_pid":0,"is_monitor":1,"factoryMapConfigList":[{"id":15,"company":"东莞市优世强精密科技有限公司","factory_name":"优世强","gather_no":"DFG20190603001","order_id":0,"create_time":1572575263000,"create_by":"07ff626a-ee46-45f9-8b69-739975d87f9d","last_time":1573207548000,"modify_by":"07ff626a-ee46-45f9-8b69-739975d87f9d","create_by_name":null,"workshop_name":"优世强"}]}
     * duration : 0
     * errorCode : null
     */

    private int status;
    private String code;
    private String message;
    private DataBean data;
    private int duration;
    private String errorCode;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static class DataBean {
        /**
         * id : 916
         * userId : 74046645-fdb3-417a-92d2-4398903a20bb
         * userName : test5162
         * passwd :
         * name : test
         * sex : 0
         * tel :
         * company_screen :
         * mobileNo : 13713917858
         * mail :
         * address :
         * userState : 1
         * pwdErrorCount : 0
         * remark : null
         * version : 0
         * createTime : 1583804090000
         * lastLoginTime : 1583804090000
         * lastTime : 1583804131000
         * type : null
         * isCompany : 1
         * isEmployee : 1
         * imgUrl : null
         * roleList : []
         * role : null
         * company : 东莞市优世强精密科技有限公司
         * companyDuty :
         * bossName :
         * bossAddress :
         * bossMoble : null
         * fax :
         * bankName : null
         * openBank :
         * bankNo :
         * card_id :
         * create_by : huanghua
         * modify_by : huanghua
         * random_no : 4
         * weixin_openid : null
         * province : 广东省
         * city : 深圳市
         * area : 南山区
         * min_openid : null
         * agent_user_id :
         * isbox : 2
         * head_title :
         * isdevice : 1
         * distribution_pid : 0
         * is_monitor : 1
         * factoryMapConfigList : [{"id":15,"company":"东莞市优世强精密科技有限公司","factory_name":"优世强","gather_no":"DFG20190603001","order_id":0,"create_time":1572575263000,"create_by":"07ff626a-ee46-45f9-8b69-739975d87f9d","last_time":1573207548000,"modify_by":"07ff626a-ee46-45f9-8b69-739975d87f9d","create_by_name":null,"workshop_name":"优世强"}]
         */

        private int id;
        private String userId;
        private String userName;
        private String passwd;
        private String name;
        private int sex;
        private String tel;
        private String company_screen;
        private String mobileNo;
        private String mail;
        private String address;
        private int userState;
        private int pwdErrorCount;
        private Object remark;
        private int version;
        private long createTime;
        private long lastLoginTime;
        private long lastTime;
        private Object type;
        private int isCompany;
        private int isEmployee;
        private Object imgUrl;
        private Object role;
        private String company;
        private String companyDuty;
        private String bossName;
        private String bossAddress;
        private Object bossMoble;
        private String fax;
        private Object bankName;
        private String openBank;
        private String bankNo;
        private String card_id;
        private String create_by;
        private String modify_by;
        private int random_no;
        private Object weixin_openid;
        private String province;
        private String city;
        private String area;
        private Object min_openid;
        private String agent_user_id;
        private int isbox;
        private String head_title;
        private int isdevice;
        private int distribution_pid;
        private int is_monitor;
        private List<?> roleList;
        private List<FactoryMapConfigListBean> factoryMapConfigList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCompany_screen() {
            return company_screen;
        }

        public void setCompany_screen(String company_screen) {
            this.company_screen = company_screen;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getUserState() {
            return userState;
        }

        public void setUserState(int userState) {
            this.userState = userState;
        }

        public int getPwdErrorCount() {
            return pwdErrorCount;
        }

        public void setPwdErrorCount(int pwdErrorCount) {
            this.pwdErrorCount = pwdErrorCount;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public int getIsCompany() {
            return isCompany;
        }

        public void setIsCompany(int isCompany) {
            this.isCompany = isCompany;
        }

        public int getIsEmployee() {
            return isEmployee;
        }

        public void setIsEmployee(int isEmployee) {
            this.isEmployee = isEmployee;
        }

        public Object getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(Object imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Object getRole() {
            return role;
        }

        public void setRole(Object role) {
            this.role = role;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCompanyDuty() {
            return companyDuty;
        }

        public void setCompanyDuty(String companyDuty) {
            this.companyDuty = companyDuty;
        }

        public String getBossName() {
            return bossName;
        }

        public void setBossName(String bossName) {
            this.bossName = bossName;
        }

        public String getBossAddress() {
            return bossAddress;
        }

        public void setBossAddress(String bossAddress) {
            this.bossAddress = bossAddress;
        }

        public Object getBossMoble() {
            return bossMoble;
        }

        public void setBossMoble(Object bossMoble) {
            this.bossMoble = bossMoble;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public Object getBankName() {
            return bankName;
        }

        public void setBankName(Object bankName) {
            this.bankName = bankName;
        }

        public String getOpenBank() {
            return openBank;
        }

        public void setOpenBank(String openBank) {
            this.openBank = openBank;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getCreate_by() {
            return create_by;
        }

        public void setCreate_by(String create_by) {
            this.create_by = create_by;
        }

        public String getModify_by() {
            return modify_by;
        }

        public void setModify_by(String modify_by) {
            this.modify_by = modify_by;
        }

        public int getRandom_no() {
            return random_no;
        }

        public void setRandom_no(int random_no) {
            this.random_no = random_no;
        }

        public Object getWeixin_openid() {
            return weixin_openid;
        }

        public void setWeixin_openid(Object weixin_openid) {
            this.weixin_openid = weixin_openid;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Object getMin_openid() {
            return min_openid;
        }

        public void setMin_openid(Object min_openid) {
            this.min_openid = min_openid;
        }

        public String getAgent_user_id() {
            return agent_user_id;
        }

        public void setAgent_user_id(String agent_user_id) {
            this.agent_user_id = agent_user_id;
        }

        public int getIsbox() {
            return isbox;
        }

        public void setIsbox(int isbox) {
            this.isbox = isbox;
        }

        public String getHead_title() {
            return head_title;
        }

        public void setHead_title(String head_title) {
            this.head_title = head_title;
        }

        public int getIsdevice() {
            return isdevice;
        }

        public void setIsdevice(int isdevice) {
            this.isdevice = isdevice;
        }

        public int getDistribution_pid() {
            return distribution_pid;
        }

        public void setDistribution_pid(int distribution_pid) {
            this.distribution_pid = distribution_pid;
        }

        public int getIs_monitor() {
            return is_monitor;
        }

        public void setIs_monitor(int is_monitor) {
            this.is_monitor = is_monitor;
        }

        public List<?> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<?> roleList) {
            this.roleList = roleList;
        }

        public List<FactoryMapConfigListBean> getFactoryMapConfigList() {
            return factoryMapConfigList;
        }

        public void setFactoryMapConfigList(List<FactoryMapConfigListBean> factoryMapConfigList) {
            this.factoryMapConfigList = factoryMapConfigList;
        }

        public static class FactoryMapConfigListBean {
            /**
             * id : 15
             * company : 东莞市优世强精密科技有限公司
             * factory_name : 优世强
             * gather_no : DFG20190603001
             * order_id : 0
             * create_time : 1572575263000
             * create_by : 07ff626a-ee46-45f9-8b69-739975d87f9d
             * last_time : 1573207548000
             * modify_by : 07ff626a-ee46-45f9-8b69-739975d87f9d
             * create_by_name : null
             * workshop_name : 优世强
             */

            private int id;
            private String company;
            private String factory_name;
            private String gather_no;
            private int order_id;
            private long create_time;
            private String create_by;
            private long last_time;
            private String modify_by;
            private Object create_by_name;
            private String workshop_name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getFactory_name() {
                return factory_name;
            }

            public void setFactory_name(String factory_name) {
                this.factory_name = factory_name;
            }

            public String getGather_no() {
                return gather_no;
            }

            public void setGather_no(String gather_no) {
                this.gather_no = gather_no;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public long getCreate_time() {
                return create_time;
            }

            public void setCreate_time(long create_time) {
                this.create_time = create_time;
            }

            public String getCreate_by() {
                return create_by;
            }

            public void setCreate_by(String create_by) {
                this.create_by = create_by;
            }

            public long getLast_time() {
                return last_time;
            }

            public void setLast_time(long last_time) {
                this.last_time = last_time;
            }

            public String getModify_by() {
                return modify_by;
            }

            public void setModify_by(String modify_by) {
                this.modify_by = modify_by;
            }

            public Object getCreate_by_name() {
                return create_by_name;
            }

            public void setCreate_by_name(Object create_by_name) {
                this.create_by_name = create_by_name;
            }

            public String getWorkshop_name() {
                return workshop_name;
            }

            public void setWorkshop_name(String workshop_name) {
                this.workshop_name = workshop_name;
            }
        }
    }
}
