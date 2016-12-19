//
//  DropShadow.swift
//  TacoPOP
//
//  Created by Frank Garcia on 12/9/16.
//  Copyright © 2016 Malibit. All rights reserved.
//

import UIKit

protocol DropShadow {}

extension DropShadow where Self: UIView {
    
    func addDropShadow() {
        
        layer.shadowColor = UIColor.black.cgColor
        layer.shadowOpacity = 0.7
        layer.shadowOffset = CGSize.zero
        layer.shadowRadius = 5
    }
}
