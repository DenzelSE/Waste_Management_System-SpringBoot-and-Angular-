import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { WasteItemsComponent } from './components/waste-items/waste-items.component';
import { CategoriesComponent } from './components/categories/categories.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'waste-items', component: WasteItemsComponent },
  { path: 'categories', component: CategoriesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
