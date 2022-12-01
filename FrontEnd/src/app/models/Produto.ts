export enum TipoProduto {
  ELETRONICO = "ELETRONICO",
  ELETRODOMESTICO = "ELETRODOMESTICO",
  MOVEL = "MOVEL"
}

export class Produto{
  id?: number;
  descricao!: string;
  tipo!: TipoProduto;
  valorFornecedor!: number;
  estoque!: number;
}
