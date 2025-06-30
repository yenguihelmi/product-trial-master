import { Injectable, inject, signal } from "@angular/core";
import { Product } from "./product.model";
import { HttpClient } from "@angular/common/http";
import { catchError, Observable, of, tap } from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
    providedIn: "root"
}) export class ProductsService {

    private readonly http = inject(HttpClient);

    private readonly path = `${environment.apiUrl}/products`;


  private readonly _products = signal<Product[]>([]);

    public readonly products = this._products.asReadonly();

    public get(): Observable<Product[]> {
        return this.http.get<Product[]>(this.path).pipe(
            catchError((error) => {
                return this.http.get<Product[]>("assets/products.json");
            }),
            tap((products) => this._products.set(products)),
        );
    }

  public create(product: Omit<Product, 'id'>): Observable<Product> {
    return this.http.post<Product>(this.path, product).pipe(
      catchError(() => {
        const newProduct = {
          ...product,
          id: Math.floor(Math.random() * 1000) + 1,
          createdAt: Date.now(),
          updatedAt: Date.now()
        };
        return of(newProduct);
      }),
      tap((createdProduct) => {
        this._products.update(products => [createdProduct, ...products]);
      })
    );
  }

    public update(product: Product): Observable<boolean> {
        return this.http.patch<boolean>(`${this.path}/${product.id}`, product).pipe(
            catchError(() => {
                return of(true);
            }),
            tap(() => this._products.update(products => {
                return products.map(p => p.id === product.id ? product : p)
            })),
        );
    }

    public delete(productId: number): Observable<boolean> {
        return this.http.delete<boolean>(`${this.path}/${productId}`).pipe(
            catchError(() => {
                return of(true);
            }),
            tap(() => this._products.update(products => products.filter(product => product.id !== productId))),
        );
    }
}
