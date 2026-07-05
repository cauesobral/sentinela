package com.caue.sentinela.action;

import com.caue.sentinela.dto.AccidentDTO;
import com.caue.sentinela.service.AccidentService;
import org.apache.struts2.ActionSupport;

import java.util.List;

public class AccidentAction extends ActionSupport {

    private AccidentService accidentService;

    private List<AccidentDTO> accidents;

    private AccidentDTO accident;

    public String list() {
        accidents = accidentService.findAll();
        //SUCCESS é uma constante do ActionSupport
        return SUCCESS;
    }

    public String details() {
        return SUCCESS;
    }

    public String create() {
        return SUCCESS;
    }

    public String save() {
        return SUCCESS;
    }

    public String edit() {
        return SUCCESS;
    }

    public String update() {
        return SUCCESS;
    }

    public String delete() {
        return SUCCESS;
    }

    public List<AccidentDTO> getAccidents() {
        return accidents;
    }

    public AccidentDTO getAccident() {
        return accident;
    }

    public void setAccident(AccidentDTO accident) {
        this.accident = accident;
    }

    public void setAccidentService(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    public String search() {
        return SUCCESS;
    }
}
