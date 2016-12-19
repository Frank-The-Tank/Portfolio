//
//  Location.swift
//  RainyShinnyDay
//
//  Created by Frank Garcia on 11/20/16.
//  Copyright © 2016 Malibit. All rights reserved.
//

import CoreLocation

class Location {
    static var sharedInstance = Location()
    private init() {}
    
    var latitude: Double!
    var longitude: Double!
}
