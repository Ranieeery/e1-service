(function () {
    "use strict";

    var TitleReceiptService = function ($resource, BASE_REST_URL_REPORT) {
        return $resource(
            BASE_REST_URL_REPORT + "title-receipt-list",
            {},
            {
                query: {
                    isArray: false,
                },
                headers: {
                    "Access-Control-Allow-Origin": "*",
                },
            }
        );
    };

    angular
        .module("reportApp")
        .service("TitleReceiptService", TitleReceiptService);
})();
