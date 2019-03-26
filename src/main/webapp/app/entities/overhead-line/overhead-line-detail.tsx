import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './overhead-line.reducer';
import { IOverheadLine } from 'app/shared/model/overhead-line.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IOverheadLineDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class OverheadLineDetail extends React.Component<IOverheadLineDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { overheadLineEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.overheadLine.detail.title">OverheadLine</Translate> [<b>{overheadLineEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="towerId">
                <Translate contentKey="brazilbmteApp.overheadLine.towerId">Tower Id</Translate>
              </span>
            </dt>
            <dd>{overheadLineEntity.towerId}</dd>
            <dt>
              <span id="towerNumber">
                <Translate contentKey="brazilbmteApp.overheadLine.towerNumber">Tower Number</Translate>
              </span>
            </dt>
            <dd>{overheadLineEntity.towerNumber}</dd>
            <dt>
              <span id="geometry">
                <Translate contentKey="brazilbmteApp.overheadLine.geometry">Geometry</Translate>
              </span>
            </dt>
            <dd>{overheadLineEntity.geometry}</dd>
          </dl>
          <Button tag={Link} to="/entity/overhead-line" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/overhead-line/${overheadLineEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ overheadLine }: IRootState) => ({
  overheadLineEntity: overheadLine.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(OverheadLineDetail);
