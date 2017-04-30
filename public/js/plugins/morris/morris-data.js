// Morris.js Charts sample data for SB Admin template

$(function() {
    // Area Chart
    setTimeout(function(){


        var arr = window.year;
        var data = [];

        for(i = 0; i < arr.length; i++){
            data[i] = {};
            data[i].period = arr[i].year.toString();
            data[i].income = (arr[i].income == null ? 0 : arr[i].income) ;
            data[i].cost = (arr[i].yearCosts == null ? 0 : arr[i].yearCosts);
            console.log(data[i].period);
        }

        Morris.Area({
            element: 'morris-area-chart',
            data: data,
            xkey: 'period',
            ykeys: ['income', 'cost'],
            labels: ['income', 'cost'],
            pointSize: 3,
            hideHover: 'auto',
    		behaveLikeLine: true,
            resize: true
        });
    },1500)

});
