// Morris.js Charts sample data for SB Admin template

$(function() {

    // Area Chart
    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2011',
            income: 26,
            cost: 27
        }, {
            period: '2012',
            income: 27,
            cost: 24
        }, {
            period: '2013',
            income: 49,
            cost: 21
        }, {
            period: '2014',
            income: 97,
            cost: 49
        }, {
            period: '2015',
            income: 60,
            cost: 14
        }],
        xkey: 'period',
        ykeys: ['income', 'cost'],
        labels: ['income', 'cost'],
        pointSize: 3,
        hideHover: 'auto',
		behaveLikeLine: true,
        resize: true
    });

});
