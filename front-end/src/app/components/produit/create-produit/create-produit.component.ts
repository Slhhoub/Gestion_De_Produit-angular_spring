import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Produit } from '../../../model/Produit';
import { ProduitService } from '../../../service/produit/produit.service';

@Component({
  selector: 'app-create-produit',
  templateUrl: './create-produit.component.html',
  styleUrl: './create-produit.component.css'
})
export class CreateProduitComponent implements OnInit{
  messageErreur=false;
  messageSuccsess=false;

  ProduitRegister!:FormGroup;

  constructor(private produitService:ProduitService,private fb:FormBuilder){}

  ngOnInit(): void {
    this.validationForm();
  }

  validationForm(){
    this.ProduitRegister=this.fb.group(
    {
      type : ['',[Validators.required]],
      reference : ['',[Validators.required]],
      description : ['',[Validators.required]],
      prix : ['',[Validators.required]],
    }
    )
  }

  saveAllProduit(produit:Produit){
    return this.produitService.saveProduit(produit).subscribe(
      (data)=>{
        if(window.confirm("add success produit")){
          window.location.reload();
        }
      },
      (error)=>{
        console.log(error);
      }
    )
  }
}
