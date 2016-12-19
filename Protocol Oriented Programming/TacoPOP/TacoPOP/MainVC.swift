//
//  ViewController.swift
//  TacoPOP
//
//  Created by Frank Garcia on 12/8/16.
//  Copyright © 2016 Malibit. All rights reserved.
//

import UIKit

class MainVC: UIViewController {
    
    @IBOutlet weak var headerView: HeaderView!
    @IBOutlet weak var collectoinView: UICollectionView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        headerView.addDropShadow()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

