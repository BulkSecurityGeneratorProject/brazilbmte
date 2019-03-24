import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './overhead-line.reducer';
import { IOverheadLine } from 'app/shared/model/overhead-line.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IOverheadLineProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class OverheadLine extends React.Component<IOverheadLineProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { overheadLineList, match } = this.props;
    return (
      <div>
        <h2 id="overhead-line-heading">
          <Translate contentKey="brazilbmteApp.overheadLine.home.title">Overhead Lines</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="brazilbmteApp.overheadLine.home.createLabel">Create new Overhead Line</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.overheadLine.towerId">Tower Id</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.overheadLine.towerNumber">Tower Number</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.overheadLine.geometry">Geometry</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {overheadLineList.map((overheadLine, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${overheadLine.id}`} color="link" size="sm">
                      {overheadLine.id}
                    </Button>
                  </td>
                  <td>{overheadLine.towerId}</td>
                  <td>{overheadLine.towerNumber}</td>
                  <td>{overheadLine.geometry}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${overheadLine.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${overheadLine.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${overheadLine.id}/delete`} color="danger" size="sm">
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
      </div>
    );
  }
}

const mapStateToProps = ({ overheadLine }: IRootState) => ({
  overheadLineList: overheadLine.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(OverheadLine);
