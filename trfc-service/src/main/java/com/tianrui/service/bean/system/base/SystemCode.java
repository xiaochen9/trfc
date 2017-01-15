package com.tianrui.service.bean.system.base;

import java.util.Date;

public class SystemCode {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.id
     *	自定义编号ID
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.code
     *	单据代号
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.name
     *	单据名称
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.key
     *	单据类型
     * @mbggenerated
     */
    private String key;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.example
     *	说明
     * @mbggenerated
     */
    private String example;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.code_type
     *	编号方式
     * @mbggenerated
     */
    private Byte codeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.split_type
     *	分割符
     * @mbggenerated
     */
    private Byte splitType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.code_begin
     *	起始编号
     * @mbggenerated
     */
    private Byte codeBegin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.inner_code_begin
     *	起始内码
     * @mbggenerated
     */
    private Byte innerCodeBegin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.creator
     *	创建者
     * @mbggenerated
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.createtime
     *	创建时间
     * @mbggenerated
     */
    private Long createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.modifier
     *	修改者
     * @mbggenerated
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.modifytime
     *	修改时间
     * @mbggenerated
     */
    private Long modifytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_system_code.utc
     *	最近更新时间/版本号
     * @mbggenerated
     */
    private Date utc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.id
     *
     * @return the value of tr_system_code.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.id
     *
     * @param id the value for tr_system_code.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.code
     *
     * @return the value of tr_system_code.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.code
     *
     * @param code the value for tr_system_code.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.name
     *
     * @return the value of tr_system_code.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.name
     *
     * @param name the value for tr_system_code.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.key
     *
     * @return the value of tr_system_code.key
     *
     * @mbggenerated
     */
    public String getKey() {
        return key;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.key
     *
     * @param key the value for tr_system_code.key
     *
     * @mbggenerated
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.example
     *
     * @return the value of tr_system_code.example
     *
     * @mbggenerated
     */
    public String getExample() {
        return example;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.example
     *
     * @param example the value for tr_system_code.example
     *
     * @mbggenerated
     */
    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.code_type
     *
     * @return the value of tr_system_code.code_type
     *
     * @mbggenerated
     */
    public Byte getCodeType() {
        return codeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.code_type
     *
     * @param codeType the value for tr_system_code.code_type
     *
     * @mbggenerated
     */
    public void setCodeType(Byte codeType) {
        this.codeType = codeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.split_type
     *
     * @return the value of tr_system_code.split_type
     *
     * @mbggenerated
     */
    public Byte getSplitType() {
        return splitType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.split_type
     *
     * @param splitType the value for tr_system_code.split_type
     *
     * @mbggenerated
     */
    public void setSplitType(Byte splitType) {
        this.splitType = splitType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.code_begin
     *
     * @return the value of tr_system_code.code_begin
     *
     * @mbggenerated
     */
    public Byte getCodeBegin() {
        return codeBegin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.code_begin
     *
     * @param codeBegin the value for tr_system_code.code_begin
     *
     * @mbggenerated
     */
    public void setCodeBegin(Byte codeBegin) {
        this.codeBegin = codeBegin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.inner_code_begin
     *
     * @return the value of tr_system_code.inner_code_begin
     *
     * @mbggenerated
     */
    public Byte getInnerCodeBegin() {
        return innerCodeBegin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.inner_code_begin
     *
     * @param innerCodeBegin the value for tr_system_code.inner_code_begin
     *
     * @mbggenerated
     */
    public void setInnerCodeBegin(Byte innerCodeBegin) {
        this.innerCodeBegin = innerCodeBegin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.creator
     *
     * @return the value of tr_system_code.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.creator
     *
     * @param creator the value for tr_system_code.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.createtime
     *
     * @return the value of tr_system_code.createtime
     *
     * @mbggenerated
     */
    public Long getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.createtime
     *
     * @param createtime the value for tr_system_code.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.modifier
     *
     * @return the value of tr_system_code.modifier
     *
     * @mbggenerated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.modifier
     *
     * @param modifier the value for tr_system_code.modifier
     *
     * @mbggenerated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.modifytime
     *
     * @return the value of tr_system_code.modifytime
     *
     * @mbggenerated
     */
    public Long getModifytime() {
        return modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.modifytime
     *
     * @param modifytime the value for tr_system_code.modifytime
     *
     * @mbggenerated
     */
    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_system_code.utc
     *
     * @return the value of tr_system_code.utc
     *
     * @mbggenerated
     */
    public Date getUtc() {
        return utc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_system_code.utc
     *
     * @param utc the value for tr_system_code.utc
     *
     * @mbggenerated
     */
    public void setUtc(Date utc) {
        this.utc = utc;
    }
}