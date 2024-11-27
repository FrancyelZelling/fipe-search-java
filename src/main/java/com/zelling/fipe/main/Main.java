package com.zelling.fipe.main;

import com.zelling.fipe.utils.ApiSearch;

public class Main {
    public void Main(){
        ApiSearch api = new ApiSearch();

        api.search("https://parallelum.com.br/fipe/api/v1");
    }
}
