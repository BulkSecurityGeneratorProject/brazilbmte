import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction, getSortState, IPaginationBaseState, getPaginationItemsNumber, JhiPagination } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './tower.reducer';
import { ITower } from 'app/shared/model/tower.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface ITowerProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type ITowerState = IPaginationBaseState;

export class Tower extends React.Component<ITowerProps, ITowerState> {
  state: ITowerState = {
    ...getSortState(this.props.location, ITEMS_PER_PAGE)
  };

  componentDidMount() {
    this.getEntities();
  }

  sort = prop => () => {
    this.setState(
      {
        order: this.state.order === 'asc' ? 'desc' : 'asc',
        sort: prop
      },
      () => this.sortEntities()
    );
  };

  sortEntities() {
    this.getEntities();
    this.props.history.push(`${this.props.location.pathname}?page=${this.state.activePage}&sort=${this.state.sort},${this.state.order}`);
  }

  handlePagination = activePage => this.setState({ activePage }, () => this.sortEntities());

  getEntities = () => {
    const { activePage, itemsPerPage, sort, order } = this.state;
    this.props.getEntities(activePage - 1, itemsPerPage, `${sort},${order}`);
  };

  render() {
    const { towerList, match, totalItems } = this.props;
    return (
      <div>
        <h2 id="tower-heading">
          <Translate contentKey="brazilbmteApp.tower.home.title">Towers</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="brazilbmteApp.tower.home.createLabel">Create new Tower</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={this.sort('id')}>
                  <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('towerNumber')}>
                  <Translate contentKey="brazilbmteApp.tower.towerNumber">Tower Number</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('serialNumber')}>
                  <Translate contentKey="brazilbmteApp.tower.serialNumber">Serial Number</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('longitude')}>
                  <Translate contentKey="brazilbmteApp.tower.longitude">Longitude</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('latitude')}>
                  <Translate contentKey="brazilbmteApp.tower.latitude">Latitude</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('altitude')}>
                  <Translate contentKey="brazilbmteApp.tower.altitude">Altitude</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('utmX')}>
                  <Translate contentKey="brazilbmteApp.tower.utmX">Utm X</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('utmY')}>
                  <Translate contentKey="brazilbmteApp.tower.utmY">Utm Y</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('progressiveDistance')}>
                  <Translate contentKey="brazilbmteApp.tower.progressiveDistance">Progressive Distance</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('isCorner')}>
                  <Translate contentKey="brazilbmteApp.tower.isCorner">Is Corner</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('corner')}>
                  <Translate contentKey="brazilbmteApp.tower.corner">Corner</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('spanDistance')}>
                  <Translate contentKey="brazilbmteApp.tower.spanDistance">Span Distance</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={this.sort('towerType')}>
                  <Translate contentKey="brazilbmteApp.tower.towerType">Tower Type</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.tower.towerStructureInfo">Tower Structure Info</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.tower.geometryJson">Geometry Json</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.tower.tender">Tender</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {towerList.map((tower, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${tower.id}`} color="link" size="sm">
                      {tower.id}
                    </Button>
                  </td>
                  <td>{tower.towerNumber}</td>
                  <td>{tower.serialNumber}</td>
                  <td>{tower.longitude}</td>
                  <td>{tower.latitude}</td>
                  <td>{tower.altitude}</td>
                  <td>{tower.utmX}</td>
                  <td>{tower.utmY}</td>
                  <td>{tower.progressiveDistance}</td>
                  <td>{tower.isCorner ? 'true' : 'false'}</td>
                  <td>{tower.corner}</td>
                  <td>{tower.spanDistance}</td>
                  <td>{tower.towerType}</td>
                  <td>
                    {tower.towerStructureInfo ? (
                      <Link to={`tower-structure-info/${tower.towerStructureInfo.id}`}>{tower.towerStructureInfo.id}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td>{tower.geometryJson ? <Link to={`geometry/${tower.geometryJson.id}`}>{tower.geometryJson.id}</Link> : ''}</td>
                  <td>{tower.tender ? <Link to={`tender/${tower.tender.id}`}>{tower.tender.id}</Link> : ''}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${tower.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${tower.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${tower.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
        <Row className="justify-content-center">
          <JhiPagination
            items={getPaginationItemsNumber(totalItems, this.state.itemsPerPage)}
            activePage={this.state.activePage}
            onSelect={this.handlePagination}
            maxButtons={5}
          />
        </Row>
      </div>
    );
  }
}

const mapStateToProps = ({ tower }: IRootState) => ({
  towerList: tower.entities,
  totalItems: tower.totalItems
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Tower);
