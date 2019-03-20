import { IGeometry } from 'app/shared/model/geometry.model';
import { IProject } from 'app/shared/model/project.model';

export interface ITender {
  id?: number;
  tenderName?: string;
  tenderLength?: string;
  towerCount?: number;
  geometryJson?: IGeometry;
  project?: IProject;
}

export const defaultValue: Readonly<ITender> = {};
