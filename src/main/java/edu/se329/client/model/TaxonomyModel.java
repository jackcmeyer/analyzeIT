package edu.se329.client.model;


import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;

public class TaxonomyModel {
    private Taxonomies taxonomyAnalysis;

    public TaxonomyModel(){

    }

    public TaxonomyModel(Taxonomies taxonomyAnalysis) {

        this.taxonomyAnalysis = taxonomyAnalysis;
    }

    public Taxonomies getTaxonomyAnalysis() {
        return taxonomyAnalysis;
    }

    public void setTaxonomyAnalysis(Taxonomies taxonomyAnalysis) {
        this.taxonomyAnalysis = taxonomyAnalysis;
    }
}
