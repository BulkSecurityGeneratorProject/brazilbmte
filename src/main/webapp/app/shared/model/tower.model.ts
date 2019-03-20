import { ITowerStructureInfo } from 'app/shared/model/tower-structure-info.model';
import { IGeometry } from 'app/shared/model/geometry.model';
import { ITender } from 'app/shared/model/tender.model';

export interface ITower {
  id?: number;
  towerNumber?: string;
  serialNumber?: number;
  longitude?: number;
  latitude?: number;
  altitude?: number;
  utmX?: number;
  utmY?: number;
  progressiveDistance?: number;
  isCorner?: boolean;
  corner?: number;
  spanDistance?: number;
  towerType?: string;
  towerStructureInfo?: ITowerStructureInfo;
  geometryJson?: IGeometry;
  tender?: ITender;
}

export const defaultValue: Readonly<ITower> = {
  isCorner: false
};
