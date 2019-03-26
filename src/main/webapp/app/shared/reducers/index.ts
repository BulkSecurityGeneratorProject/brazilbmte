import { combineReducers } from 'redux';
import { loadingBarReducer as loadingBar } from 'react-redux-loading-bar';

import locale, { LocaleState } from './locale';
import authentication, { AuthenticationState } from './authentication';
import applicationProfile, { ApplicationProfileState } from './application-profile';

import administration, { AdministrationState } from 'app/modules/administration/administration.reducer';
import userManagement, { UserManagementState } from 'app/modules/administration/user-management/user-management.reducer';
import register, { RegisterState } from 'app/modules/account/register/register.reducer';
import activate, { ActivateState } from 'app/modules/account/activate/activate.reducer';
import password, { PasswordState } from 'app/modules/account/password/password.reducer';
import settings, { SettingsState } from 'app/modules/account/settings/settings.reducer';
import passwordReset, { PasswordResetState } from 'app/modules/account/password-reset/password-reset.reducer';
// prettier-ignore
import project, {
  ProjectState
} from 'app/entities/project/project.reducer';
// prettier-ignore
import tender, {
  TenderState
} from 'app/entities/tender/tender.reducer';
// prettier-ignore
import tower, {
  TowerState
} from 'app/entities/tower/tower.reducer';
// prettier-ignore
import geometry, {
  GeometryState
} from 'app/entities/geometry/geometry.reducer';
// prettier-ignore
import towerStructureInfo, {
  TowerStructureInfoState
} from 'app/entities/tower-structure-info/tower-structure-info.reducer';
// prettier-ignore
import towerTemp, {
  TowerTempState
} from 'app/entities/tower-temp/tower-temp.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

export interface IRootState {
  readonly authentication: AuthenticationState;
  readonly locale: LocaleState;
  readonly applicationProfile: ApplicationProfileState;
  readonly administration: AdministrationState;
  readonly userManagement: UserManagementState;
  readonly register: RegisterState;
  readonly activate: ActivateState;
  readonly passwordReset: PasswordResetState;
  readonly password: PasswordState;
  readonly settings: SettingsState;
  readonly project: ProjectState;
  readonly tender: TenderState;
  readonly tower: TowerState;
  readonly geometry: GeometryState;
  readonly towerStructureInfo: TowerStructureInfoState;
  readonly towerTemp: TowerTempState;
  /* jhipster-needle-add-reducer-type - JHipster will add reducer type here */
  readonly loadingBar: any;
}

const rootReducer = combineReducers<IRootState>({
  authentication,
  locale,
  applicationProfile,
  administration,
  userManagement,
  register,
  activate,
  passwordReset,
  password,
  settings,
  project,
  tender,
  tower,
  geometry,
  towerStructureInfo,
  towerTemp,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
  loadingBar
});

export default rootReducer;
