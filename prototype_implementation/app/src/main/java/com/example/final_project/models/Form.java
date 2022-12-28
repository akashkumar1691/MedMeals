package com.example.final_project.models;

import java.util.List;

public class Form {
    private String p_username;
    private String doc_username;
    private List<String> diagnosis;
    private List<String> foods_to_avoid;
    private String doc_notes;

    public Form(String p_user, String doc_user, List<String> diag, List<String> fta, String docNotes) {
       this.p_username = p_user;
       this.doc_username = doc_user;
       this.foods_to_avoid = fta;
       this.doc_notes = docNotes;
       this.diagnosis = diag;
    }

    public String get_patient_username() {
        return this.p_username;
    }

    public String get_doc_username() {
        return this.doc_username;
    }
    public List<String> get_diagnosis() {
        return this.diagnosis;
    }
    public List<String> get_foods_to_avoid() {
        return this.foods_to_avoid;
    }
    public String get_doc_notes() {
        return this.doc_notes;
    }
}
