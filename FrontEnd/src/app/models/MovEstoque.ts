import { Produto } from "./Produto";

export enum TipoMovimento {
  ENTRADA = "ENTRADA",
  SAIDA = "SAIDA"
}

export class MovEstoque{
  id?: number;
  produto!: Produto[];
  tipoMovimentacao!: TipoMovimento;
  valorVenda?: number;
  data?: Date;
  qtdeMovimentada!: number;
}
