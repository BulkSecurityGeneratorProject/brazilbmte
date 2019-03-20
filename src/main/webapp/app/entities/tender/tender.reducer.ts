import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITender, defaultValue } from 'app/shared/model/tender.model';

export const ACTION_TYPES = {
  FETCH_TENDER_LIST: 'tender/FETCH_TENDER_LIST',
  FETCH_TENDER: 'tender/FETCH_TENDER',
  CREATE_TENDER: 'tender/CREATE_TENDER',
  UPDATE_TENDER: 'tender/UPDATE_TENDER',
  DELETE_TENDER: 'tender/DELETE_TENDER',
  RESET: 'tender/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITender>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type TenderState = Readonly<typeof initialState>;

// Reducer

export default (state: TenderState = initialState, action): TenderState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TENDER_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TENDER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_TENDER):
    case REQUEST(ACTION_TYPES.UPDATE_TENDER):
    case REQUEST(ACTION_TYPES.DELETE_TENDER):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_TENDER_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TENDER):
    case FAILURE(ACTION_TYPES.CREATE_TENDER):
    case FAILURE(ACTION_TYPES.UPDATE_TENDER):
    case FAILURE(ACTION_TYPES.DELETE_TENDER):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_TENDER_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_TENDER):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_TENDER):
    case SUCCESS(ACTION_TYPES.UPDATE_TENDER):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_TENDER):
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

const apiUrl = 'api/tenders';

// Actions

export const getEntities: ICrudGetAllAction<ITender> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_TENDER_LIST,
  payload: axios.get<ITender>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ITender> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TENDER,
    payload: axios.get<ITender>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ITender> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TENDER,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITender> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TENDER,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITender> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TENDER,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
