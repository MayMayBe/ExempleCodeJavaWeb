        function initialize() {
            var mapOptions = {
                zoom: 15,
                center: new google.maps.LatLng(50.471322, 4.854788),
                mapTypeId: google.maps.MapTypeId.ROAD,
                scrollwheel: false
            }
            var map = new google.maps.Map(document.getElementById('map'),
                mapOptions);

            var myLatLng = new google.maps.LatLng(50.471322, 4.854788);
            var marker = new google.maps.Marker({
                position: myLatLng,
                map: map
            });
        }

        google.maps.event.addDomListener(window, 'load', initialize);