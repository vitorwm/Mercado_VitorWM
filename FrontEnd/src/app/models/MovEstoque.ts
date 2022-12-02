import { Produto } from "./Produto";

export enum TipoMovimento {
  ENTRADA = "ENTRADA",
  SAIDA = "SAIDA"
}

export class MovEstoque{
  id?: number;
  tipoMovimentacao!: TipoMovimento;
  valorVenda?: number;
  qtdeMovimentada!: number;
  data?: Date;
  produto!: {
    id : number;
  };

}
