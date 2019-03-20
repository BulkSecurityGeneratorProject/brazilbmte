import { IGeometry } from 'app/shared/model/geometry.model';

export interface IProject {
  id?: number;
  projectName?: string;
  voltage?: string;
  description?: string;
  projectLength?: string;
  towerCount?: number;
  geometryJson?: IGeometry;
}

export const defaultValue: Readonly<IProject> = {};
