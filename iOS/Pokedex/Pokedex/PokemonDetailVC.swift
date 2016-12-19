//
//  PokemonDetailVC.swift
//  Pokedex
//
//  Created by Frank Garcia on 11/24/16.
//  Copyright © 2016 Malibit. All rights reserved.
//

import UIKit

class PokemonDetailVC: UIViewController {
    
    @IBOutlet weak var decider: UISegmentedControl!
    
    @IBOutlet weak var nameLbl: UILabel!
    @IBOutlet weak var mainImg: UIImageView!
    @IBOutlet weak var descriptionLbl: UILabel!
    @IBOutlet weak var typeLbl: UILabel!
    @IBOutlet weak var defenseLbl: UILabel!
    @IBOutlet weak var heightLbl: UILabel!
    @IBOutlet weak var pokedexLbl: UILabel!
    @IBOutlet weak var weightLbl: UILabel!
    @IBOutlet weak var attackLbl: UILabel!
    @IBOutlet weak var currentEvoImg: UIImageView!
    @IBOutlet weak var nextEvoImg: UIImageView!
    @IBOutlet weak var evoLbl: UILabel!
    
    @IBOutlet weak var typePlaceholder: UILabel!
    @IBOutlet weak var heightPlaceholder: UILabel!
    @IBOutlet weak var weightPlaceholder: UILabel!
    @IBOutlet weak var defensePlaceholder: UILabel!
    @IBOutlet weak var pokedexPlaceholder: UILabel!
    @IBOutlet weak var attackPlaceholder: UILabel!
    @IBOutlet weak var evoPlaceholder: UIView!
    
    @IBOutlet weak var movesView: UITableView!
    
    var pokemon: Pokemon!

    override func viewDidLoad() {
        super.viewDidLoad()
        
        nameLbl.text = pokemon.name.capitalized
        
        let img = UIImage(named: "\(pokemon.pokedexId)")
        
        mainImg.image = img
        currentEvoImg.image = img
        pokedexLbl.text = "\(pokemon.pokedexId)"
        
        pokemon.downloadPokemonDetail {
            // whatever you write here will only be called after network call is complete
            self.updateUI()
        }
        
    }
    
    func updateUI() {
        
        attackLbl.text = pokemon.attack
        defenseLbl.text = pokemon.defense
        heightLbl.text = pokemon.height
        weightLbl.text = pokemon.weight
        typeLbl.text = pokemon.type
        descriptionLbl.text = pokemon.description
        
        if pokemon.nextEvolutionId == "" {
            
            evoLbl.text = "No Evolutions"
            nextEvoImg.isHidden = true
            
        } else {
            
            nextEvoImg.isHidden = false
            nextEvoImg.image = UIImage(named: pokemon.nextEvolutionId)
            let str = "Next Evolution: \(pokemon.nextEvolutionName) - LVL \(pokemon.nextEvolutionLevel)"
            evoLbl.text = str
        }
        
    }
    
    @IBAction func backBtnPressed(_ sender: UIButton) {
        
        dismiss(animated: true, completion: nil)
        
    }
    
    @IBAction func decider(_ sender: UISegmentedControl) {
        
        switch decider.selectedSegmentIndex {
        case 0:
            mainImg.isHidden = false
            descriptionLbl.isHidden = false
            typeLbl.isHidden = false
            defenseLbl.isHidden = false
            heightLbl.isHidden = false
            pokedexLbl.isHidden = false
            weightLbl.isHidden = false
            attackLbl.isHidden = false
            currentEvoImg.isHidden = false
            nextEvoImg.isHidden = false
            evoLbl.isHidden = false
            typePlaceholder.isHidden = false
            heightPlaceholder.isHidden = false
            weightPlaceholder.isHidden = false
            defensePlaceholder.isHidden = false
            pokedexPlaceholder.isHidden = false
            attackPlaceholder.isHidden = false
            evoPlaceholder.isHidden = false
            movesView.isHidden = true
            break;
        case 1:
            mainImg.isHidden = true
            descriptionLbl.isHidden = true
            typeLbl.isHidden = true
            defenseLbl.isHidden = true
            heightLbl.isHidden = true
            pokedexLbl.isHidden = true
            weightLbl.isHidden = true
            attackLbl.isHidden = true
            currentEvoImg.isHidden = true
            nextEvoImg.isHidden = true
            evoLbl.isHidden = true
            typePlaceholder.isHidden = true
            heightPlaceholder.isHidden = true
            weightPlaceholder.isHidden = true
            defensePlaceholder.isHidden = true
            pokedexPlaceholder.isHidden = true
            attackPlaceholder.isHidden = true
            evoPlaceholder.isHidden = true
            movesView.isHidden = false
            break;
        default:
            break;
        }
        
    }
    

}
