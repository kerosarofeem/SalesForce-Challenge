describe("LoadTweets", function () {
    it("should fetch from a server", function () {
        var loadtweets = new LoadTweets();

        // creating our spied callback
        var callback = jasmine.createSpy('callback');
        var data = [
              {x: 0,  y: 0},
        ];

        spyOn($, 'ajax').and.callFake(function (req) {
            var d = $.Deferred();
           // resolve using our mock data
            d.resolve(data);
            return d.promise();
        });

        async.fetch(callback);

        // grabbing the returned arguments from the spied call:
        var fakeData = callback.calls.mostRecent().args[0];
        expect(fakeData[0].x).toEqual(data[0].x);
    });
}); 