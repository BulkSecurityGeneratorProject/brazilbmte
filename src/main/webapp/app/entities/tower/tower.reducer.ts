import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITower, defaultValue } from 'app/shared/model/tower.model';

export const ACTION_TYPES = {
  FETCH_TOWER_LIST: 'tower/FETCH_TOWER_LIST',
  FETCH_TOWER: 'tower/FETCH_TOWER',
  CREATE_TOWER: 'tower/CREATE_TOWER',
  UPDATE_TOWER: 'tower/UPDATE_TOWER',
  DELETE_TOWER: 'tower/DELETE_TOWER',
  RESET: 'tower/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITower>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type TowerState = Readonly<typeof initialState>;

// Reducer

export default (state: TowerState = initialState, action): TowerState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TOWER_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TOWER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_TOWER):
    case REQUEST(ACTION_TYPES.UPDATE_TOWER):
    case REQUEST(ACTION_TYPES.DELETE_TOWER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_TOWER_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TOWER):
    case FAILURE(ACTION_TYPES.CREATE_TOWER):
    case FAILURE(ACTION_TYPES.UPDATE_TOWER):
    case FAILURE(ACTION_TYPES.DELETE_TOWER):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWER_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWER):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_TOWER):
    case SUCCESS(ACTION_TYPES.UPDATE_TOWER):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_TOWER):
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

const apiUrl = 'api/towers';

// Actions

export const getEntities: ICrudGetAllAction<ITower> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_TOWER_LIST,
    payload: axios.get<ITower>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<ITower> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TOWER,
    payload: axios.get<ITower>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ITower> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TOWER,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITower> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TOWER,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITower> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TOWER,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
