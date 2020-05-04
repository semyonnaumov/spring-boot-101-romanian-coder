(function(){
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];
    function BookingsController($http) {
        let vm = this;

        vm.bookings = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            const url = '/bookings/all';
            let bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            })
        }

        function getAffordable() {
            const url = '/bookings/affordable/' + 100;
            let bookingsPromise = $http.get(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            })
        }

        function deleteBooking(id) {
            const url = '/bookings/delete/' + id;
            let bookingsPromise = $http.post(url);
            bookingsPromise.then(function (response) {
                vm.bookings = response.data;
            })
        }
    }
})();