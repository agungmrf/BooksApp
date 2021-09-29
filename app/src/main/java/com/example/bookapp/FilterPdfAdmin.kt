package com.example.bookapp

import android.widget.Filter

/**
 * @Author: Agung Ma'ruf
 * @Date: 28/09/2021
 */

/*Used to filter data from recylerview I search pdf from pdf list in recylerview*/
class FilterPdfAdmin : Filter {
    //arraylist in which we want to search
    var filterList: ArrayList<ModelPdf>

    //adapter in which filter need to be implemented
    var adapterPdfAdmin: AdapterPdfAdmin

    //constructor
    constructor(filterList: ArrayList<ModelPdf>, adapterPdfAdmin: AdapterPdfAdmin) {
        this.filterList = filterList
        this.adapterPdfAdmin = adapterPdfAdmin
    }

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var constraint: CharSequence? = constraint //value to search
        val results = FilterResults()

        //value to be searched should not be null and not empty
        if (constraint != null && constraint.isEmpty()) {
            //change to uppercase, or lowercase to avoid case sensitivity
            constraint = constraint.toString().lowercase()
            var filteredModels = ArrayList<ModelPdf>()
            for (i in filterList.indices) {
                //validate if match
                if (filterList[i].title.lowercase().contains(constraint)) {
                    //searched value is similar to value in list, add to filtered list
                    filteredModels.add(filterList[i])
                }
            }
            results.count = filteredModels.size
            results.values = filteredModels
        }
        else{
            //searched value is either null or empty, return all data
            results.count = filterList.size
            results.values = filterList
        }
        return results //don't miss
    }

    override fun publishResults(constraint: CharSequence, results: FilterResults) {
        //apply filter change
        adapterPdfAdmin.pdfArrayList = results.values as ArrayList<ModelPdf>

        //notify change
        adapterPdfAdmin.notifyDataSetChanged()
    }
}