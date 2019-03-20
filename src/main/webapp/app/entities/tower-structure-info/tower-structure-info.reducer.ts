import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITowerStructureInfo, defaultValue } from 'app/shared/model/tower-structure-info.model';

export const ACTION_TYPES = {
  FETCH_TOWERSTRUCTUREINFO_LIST: 'towerStructureInfo/FETCH_TOWERSTRUCTUREINFO_LIST',
  FETCH_TOWERSTRUCTUREINFO: 'towerStructureInfo/FETCH_TOWERSTRUCTUREINFO',
  CREATE_TOWERSTRUCTUREINFO: 'towerStructureInfo/CREATE_TOWERSTRUCTUREINFO',
  UPDATE_TOWERSTRUCTUREINFO: 'towerStructureInfo/UPDATE_TOWERSTRUCTUREINFO',
  DELETE_TOWERSTRUCTUREINFO: 'towerStructureInfo/DELETE_TOWERSTRUCTUREINFO',
  RESET: 'towerStructureInfo/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITowerStructureInfo>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type TowerStructureInfoState = Readonly<typeof initialState>;

// Reducer

export default (state: TowerStructureInfoState = initialState, action): TowerStructureInfoState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_TOWERSTRUCTUREINFO):
    case REQUEST(ACTION_TYPES.UPDATE_TOWERSTRUCTUREINFO):
    case REQUEST(ACTION_TYPES.DELETE_TOWERSTRUCTUREINFO):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO):
    case FAILURE(ACTION_TYPES.CREATE_TOWERSTRUCTUREINFO):
    case FAILURE(ACTION_TYPES.UPDATE_TOWERSTRUCTUREINFO):
    case FAILURE(ACTION_TYPES.DELETE_TOWERSTRUCTUREINFO):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_TOWERSTRUCTUREINFO):
    case SUCCESS(ACTION_TYPES.UPDATE_TOWERSTRUCTUREINFO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_TOWERSTRUCTUREINFO):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/tower-structure-infos';

// Actions

export const getEntities: ICrudGetAllAction<ITowerStructureInfo> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO_LIST,
  payload: axios.get<ITowerStructureInfo>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ITowerStructureInfo> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TOWERSTRUCTUREINFO,
    payload: axios.get<ITowerStructureInfo>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ITowerStructureInfo> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TOWERSTRUCTUREINFO,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITowerStructureInfo> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TOWERSTRUCTUREINFO,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITowerStructureInfo> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TOWERSTRUCTUREINFO,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
